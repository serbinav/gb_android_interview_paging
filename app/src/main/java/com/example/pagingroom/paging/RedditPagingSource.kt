package com.example.pagingroom.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingroom.model.ChildrenDataDTO
import com.example.pagingroom.repository.RedditRepository

class RedditPagingSource(
    private val redditRepository: RedditRepository
) : PagingSource<String, ChildrenDataDTO>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ChildrenDataDTO> {
        return try {
            val responseDTO = redditRepository.getRedditNews(after = params.key, limit = 25)
            LoadResult.Page(
                data = responseDTO?.data?.children ?: listOf(),
                prevKey = null,
                nextKey = if (responseDTO?.data?.children?.isNotEmpty() == true) responseDTO.data.after else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, ChildrenDataDTO>): String? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            val lastPost = page?.data?.last()
            lastPost?.data?.id
        }
    }
}