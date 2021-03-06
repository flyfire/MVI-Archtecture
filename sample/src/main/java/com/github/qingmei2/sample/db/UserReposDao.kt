package com.github.qingmei2.sample.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.qingmei2.sample.entity.Repo
import io.reactivex.Completable

@Dao
interface UserReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repos: List<Repo>)

    @Query("SELECT * FROM user_repos ORDER BY indexInSortResponse ASC")
    fun queryRepos(): DataSource.Factory<Int, Repo>

    @Query("DELETE FROM user_repos")
    fun deleteAllRepos()

    @Query("SELECT MAX(indexInSortResponse) + 1 FROM user_repos")
    fun getNextIndexInRepos(): Int
}