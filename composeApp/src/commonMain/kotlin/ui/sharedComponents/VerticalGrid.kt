package ui.sharedComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> VerticalGrid(
    items: List<T>,
    key: ((item: T) -> Any)? = null,
    content: @Composable (T) -> Unit,
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(324.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement =  Arrangement.spacedBy(16.dp)
    ){
        items(
            items = items,
            key = key
        ) { item ->
            content(item)
        }
    }
}