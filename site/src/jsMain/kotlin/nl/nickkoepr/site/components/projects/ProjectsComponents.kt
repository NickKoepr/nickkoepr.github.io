package nl.nickkoepr.site.components.projects

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id

/**
 * [Column] for project items.
 *
 * @param content the content that will be displayed in the column.
 */
@Composable
fun ProjectsColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier.id("projects"), horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}