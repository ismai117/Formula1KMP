package org.ncgroup.formula1kmp.imageLoader

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.rememberImagePainter

@Composable
fun ImageLoader(
    modifier: Modifier = Modifier,
    url: String,
    description: String
){
    val painter = rememberImagePainter(url)
    Image(
        painter = painter,
        contentDescription = description,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

