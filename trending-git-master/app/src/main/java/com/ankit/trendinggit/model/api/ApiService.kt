package com.ankit.trendinggit.model.api

import com.ankit.trendinggit.model.GitResponse
import com.ankit.trendinggit.model.RepoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun getRepo(@Query("q") search: String = "trending", @Query("sort") sort: String = "stars"): Call<GitResponse>

    @GET("users/{username}/repos")
    fun getRepoByUserName(
            @Path("username") username: String
    ): Call<List<RepoData>>
}