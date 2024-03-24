package com.brohit.margh.domain.model

import androidx.annotation.DrawableRes
import com.brohit.margh.R

data class ImageQuoteModel(
    @DrawableRes val image: Int,
    val title: String,
)


val FakeQuotes = listOf(
    ImageQuoteModel(R.drawable.one, "quote one"),
    ImageQuoteModel(R.drawable.two, "quote one"),
    ImageQuoteModel(R.drawable.three, "quote one"),
    ImageQuoteModel(R.drawable.four, "quote one"),
    ImageQuoteModel(R.drawable.five, "quote one"),
    ImageQuoteModel(R.drawable.six, "quote one"),
)