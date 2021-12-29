package com.eric.marvelapi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.eric.marvelapi.comics.data.ComicRepository
import com.eric.marvelapi.comics.ui.ComicsViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ComicsViewModelTest {

    @get : Rule
    var hiltrule = HiltAndroidRule(this)

    @Inject
     lateinit var repository: ComicRepository

     @Inject
     lateinit var viewModel: ComicsViewModel

    @Before
    fun setup() {
        hiltrule.inject()
    }

    @Test
    fun teste_getComic_success() {
        viewModel.getComics()
    }
}