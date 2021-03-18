package com.endriu.tmdbclient.data.repository.tvshow.datasource

import com.endriu.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TvShowList>
}