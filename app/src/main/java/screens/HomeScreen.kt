package screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.rawnet.R
import com.project.rawnet.ui.theme.*
import navigation.Navigation
@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())

    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()

        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {


                HeaderHome()
                Spacer(modifier = Modifier.padding(10.dp))
                SlidingBannerView()
                Spacer(modifier = Modifier.padding(10.dp))
                PageIndicator(pageCount = 10)
                Spacer(modifier = Modifier.padding(10.dp))
                PopularItemSection()
                Spacer(modifier = Modifier.padding(10.dp))
                PouplarItems()
                Spacer(modifier = Modifier.padding(10.dp))
                PoularItems()
                Spacer(modifier = Modifier.padding(10.dp))





            }

        }


    }

}
@Composable
fun HeaderHome(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween




    )
    {
        Image(painter = painterResource(R.drawable.rawnet) ,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(horizontal = 0.dp)

        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "menu",
                tint = Color.Black,
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .size(32.dp, 32.dp)
            )

        }
    }
}
@Composable
fun SlidingBannerView() {
    Image(
        painter = painterResource(id = R.drawable.banner1),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun PageIndicator(pageCount: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(if (pageCount == 0) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 0) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 1) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 1) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 2) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 2) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 3) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 3) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 4) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 4) dark_gray else Color.LightGray)
            )

            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 5) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 5) dark_gray else Color.LightGray)
            )

        }
    }

}

@Composable
fun Dashboard()
{
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier= Modifier.padding(innerPadding)


    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(40.dp),
        backgroundColor = Color.White,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(
        R.drawable.home,
        R.drawable.home
    ),
    List(
        R.drawable.email,
        R.drawable.email
    ),
    ShoppingCart(
        R.drawable.user,
        R.drawable.user
    ),
    Profile(
        R.drawable.compass,
        R.drawable.compass

    ),
}




