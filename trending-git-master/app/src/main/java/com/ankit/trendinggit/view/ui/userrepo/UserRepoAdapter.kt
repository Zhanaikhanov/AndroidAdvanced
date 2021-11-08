package com.ankit.trendinggit.view.ui.userrepo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ankit.trendinggit.R
import com.ankit.trendinggit.model.RepoData
import com.squareup.picasso.Picasso

class UserRepoAdapter(private val repoList: List<RepoData>): RecyclerView.Adapter<UserRepoAdapter.UserRepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepoViewHolder {
        return UserRepoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_repo, parent, false))
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: UserRepoViewHolder, position: Int) {
        holder.bindView(repoList[position])
    }

    inner class UserRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val iconImageView = view.findViewById<ImageView>(R.id.item_avatar)
        private val nameRepoTextView = view.findViewById<TextView>(R.id.item_name)
        private val repoDescTextView = view.findViewById<TextView>(R.id.item_description)
        private val forkCountTextView = view.findViewById<TextView>(R.id.item_fork_count)
        private val startCountTextView = view.findViewById<TextView>(R.id.item_star_count)
        private val issueCountTextView = view.findViewById<TextView>(R.id.item_issues_count)

        fun bindView(repoData: RepoData) {
            Picasso.get().load(repoData.owner?.avatar_url).into(iconImageView)
            nameRepoTextView.text = repoData.full_name
            repoDescTextView.text = repoData.description
            forkCountTextView.text = repoData.forks_count?.toString()
            startCountTextView.text = repoData.stargazers_count?.toString()
            issueCountTextView.text = repoData.open_issues_count?.toString() + "issues"
        }
    }
}