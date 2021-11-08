package com.ankit.trendinggit.view.ui.userrepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankit.trendinggit.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRepoFragment : Fragment() {

    private val viewModel: UserRepoViewModel by viewModel()

    private lateinit var userNameEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var repoListRecyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userNameEditText = view.findViewById(R.id.username_edit_text)
        searchButton = view.findViewById(R.id.search_button)
        repoListRecyclerView = view.findViewById(R.id.repo_list_recycler_view)
        searchButton.setOnClickListener {
            viewModel.onSearchClicked(userNameEditText.text.toString())
        }
        initObservers()
    }

    private fun initObservers() {
        viewModel.repoListLiveData.observe(viewLifecycleOwner, Observer {
            repoListRecyclerView.adapter = UserRepoAdapter(it)
            repoListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        })
    }
}