package com.tv_storage.favorite_movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tv_storage.favorite_movies.ui.theme.FavoritemoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FavoritemoviesTheme {
                MoviesScreen()
            }
        }
    }
}


@Composable
fun MoviesScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        SpaceBetweenSections()
        Divider()
        AllMoviesHeader()
        SpaceBetweenSections()
        MovieCards()
        SpaceBetweenSections()
        AddMovieInput()
        SpaceBetweenSections()
        Divider()
        SpaceBetweenSections()
        FavoriteMoviesHeader()
        SpaceBetweenSections()
        FavoriteMovieCards()
        SpaceBetweenSections()
        AddFavoriteMovieInput()
        SpaceBetweenSections()
        Divider()
        SpaceBetweenSections()
        MovieListHeader()
        SpaceBetweenSections()
        MovieListCards()
        SpaceBetweenSections()
        BottomBar()
    }
}

@Composable
fun SpaceBetweenSections() {
    Spacer(modifier = Modifier.padding(4.dp))
}

@Composable
fun Divider() {
    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = Color.Black,
        thickness = 1.dp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Movies") },
        navigationIcon = {
            IconButton( onClick = {}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Composable
fun AllMoviesHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.clapperboard),
            contentDescription = "Movie Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "All Movies", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        IconButton( onClick = {}) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go to all movies")
        }
    }
}

@Composable
fun MovieCards() {
    val movieImages = listOf(
        R.drawable.dune,R.drawable.pirates,
        R.drawable.hp,R.drawable.dp3,
        R.drawable.rat
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp)
    ) {
        movieImages.forEach { movieImage ->
            Image(
                painter = painterResource(id = movieImage),
                contentDescription = "Movies")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMovieInput() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp).padding(start = 6.dp, end = 6.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search movies")},
            modifier = Modifier.width(260.dp).height(56.dp),
            shape = MaterialTheme.shapes.extraSmall,
          //  colors = TextFieldDefaults.textFieldColors(containerColor = Color.Cyan)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            modifier = Modifier.height(56.dp).width(150.dp),
            shape = RectangleShape,
            content = { Text(text = "Search") }
        )
    }
}

@Composable
fun FavoriteMoviesHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.movie),
            contentDescription = "Movie Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "Favorite Movies", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        IconButton( onClick = {}) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go to favorite movies")
        }
    }
}

@Composable
fun FavoriteMovieCards() {
    val movieImages = listOf(
        R.drawable.dp3,R.drawable.fg,
        R.drawable.dune,R.drawable.soho,
        R.drawable.gorge
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp)
    ) {
        movieImages.forEach { movieImage ->
            Image(
                painter = painterResource(id = movieImage),
                contentDescription = "Favorite Movies")
        }
    }
}

@Composable
fun AddFavoriteMovieInput() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp).padding(start = 6.dp, end = 6.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Add movie to favorites")},
            modifier = Modifier.width(260.dp).height(56.dp),
            shape = MaterialTheme.shapes.extraSmall,
            //  colors = TextFieldDefaults.textFieldColors(containerColor = Color.Cyan)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            modifier = Modifier.height(56.dp).width(150.dp),
            shape = RectangleShape,
            content = { Text(text = "Add") }
        )
    }
}

@Composable
fun MovieListHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.movielist),
            contentDescription = "Movie Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = "My Lists", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        IconButton( onClick = {}) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go to favorite movies")
        }
    }
}

@Composable
fun MovieListCards() {
    val movieImages = listOf(
        R.drawable.hmovies,R.drawable.umovies,
        R.drawable.cmovies,R.drawable.add,
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp)
    ) {
        movieImages.forEach { movieImage ->
            Image(
                painter = painterResource(id = movieImage),
                contentDescription = "Favorite Movies")
        }
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification")
        }
        IconButton(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }
        IconButton(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Notification",
                modifier = Modifier.graphicsLayer(rotationY = 180f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MoviesScreen()
}