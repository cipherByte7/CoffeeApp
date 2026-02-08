import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.Presentation.screens.HomeScreen.CategoryChips

@Preview(showBackground = true)
@Composable
fun HomeCategories() {

    val categories = listOf(
        "All Coffee",
        "Macchiato",
        "Latte",
        "Americano",
        "Snacks",
        "Desserts"
    )

    var selectedCategory by remember { mutableStateOf(categories.first()) }


}
