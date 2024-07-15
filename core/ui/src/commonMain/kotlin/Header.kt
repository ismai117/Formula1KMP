package ui.sharedComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    leadingText: String,
    leadingTextStyle: TextStyle,
    trailingText: String,
    trailingTextStyle: TextStyle
){
    Box(
        modifier = modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    ){

        Text(
            text = leadingText,
            style = leadingTextStyle,
            modifier = modifier
                .padding(start = 24.dp)
                .align(Alignment.CenterStart)
        )

        Text(
            text = trailingText,
            style = trailingTextStyle,
            modifier = modifier
                .padding(end = 24.dp)
                .align(Alignment.CenterEnd)
        )

    }
}