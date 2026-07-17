import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.Presentation.screens.HomeScreen.CategoryChips

//@Preview(showBackground = true)
@Composable
fun HomeCategories(
    selectedCategory: String,
    onCategorySelected: (String?) -> Unit
) {

    val categories = listOf(
        "All Coffee",
        "Hot Coffee",
        "Cold Coffee",
        "Chocolate",
        "Dessert Coffee"
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(vertical = 12.dp)
    ) {

        items(categories) { category ->

            CategoryChips(
                text = category,
                isSelected = selectedCategory == category,
                onSelected = {

                    if (category == "All Coffee") {
                        onCategorySelected(null)
                    } else {
                        onCategorySelected(category)
                    }

                }
            )

        }

    }
}
