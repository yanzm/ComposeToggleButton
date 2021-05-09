package net.yanzm.togglebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatAlignCenter
import androidx.compose.material.icons.filled.FormatAlignLeft
import androidx.compose.material.icons.filled.FormatAlignRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import net.yanzm.togglebutton.ui.theme.ComposeToggleButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToggleButtonTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        FormatAlignToggleButton()
                    }
                }
            }
        }
    }
}

enum class FormatAlign(
    val imageVector: ImageVector,
    val contentDescription: String
) {
    LEFT(Icons.Default.FormatAlignLeft, "align horizontal left"),
    CENTER(Icons.Default.FormatAlignCenter, "align horizontal center"),
    RIGHT(Icons.Default.FormatAlignRight, "align horizontal right")
}

@Composable
fun FormatAlignToggleButton() {
    var selected by remember { mutableStateOf(FormatAlign.LEFT) }

    val values = FormatAlign.values()
    val itemCount = values.size

    IconToggleButtonGroup(selected.ordinal, itemCount) { index ->
        val align = values[index]
        IconToggleButton(
            imageVector = align.imageVector,
            contentDescription = align.contentDescription,
            checked = selected == align,
            onCheckedChange = { selected = align },
        )
    }
}
