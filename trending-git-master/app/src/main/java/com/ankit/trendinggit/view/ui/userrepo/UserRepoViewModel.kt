package com.ankit.trendinggit.view.ui.userrepo

import androidx.lifecycle.MutableLiveData
import com.ankit.trendinggit.model.RepoData
import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.view.base.BaseViewModel

class UserRepoViewModel(
        private val repoRepository: RepoRepository
): BaseViewModel() {

    val repoListLiveData = MutableLiveData<List<RepoData>>()

    fun onSearchClicked(username: String) {
        repoRepository.getRepoByUserName(username
        ) { isSuccess, response ->
            if (isSuccess) {
                repoListLiveData.value = response
            }
        }
    }
}