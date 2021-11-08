package com.ankit.trendinggit

import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.view.ui.userrepo.UserRepoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        RepoRepository.getInstance()
    }

    viewModel {
        UserRepoViewModel(
                repoRepository = get()
        )
    }
}