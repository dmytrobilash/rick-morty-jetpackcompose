package com.dmytrobilash.rickmortyapijetpackcompose

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dmytrobilash.rickmortyapijetpackcompose.ui.theme.RickMortyApiJetpackComposeTheme
import com.dmytrobilash.rickmortyapijetpackcompose.viewmodel.DetailedPersonInfoViewModel

class DetailedPersonInformation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = ViewModelProvider(this).get(DetailedPersonInfoViewModel::class.java)
        vm.responseDetailed?.let { Log.v("TAG", it.toString()) }
        setContent {
            RickMortyApiJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GoBack()
                    //ImageName()
                    //Information()
                    //DetailedInformation()
                }
            }
        }
    }
}

@Composable
fun GoBack(){
    val context = LocalContext.current
    Row (
        modifier = Modifier
            .padding(24.dp, 24.dp)
    ){

        Image(
            painter = painterResource(R.drawable.baseline_arrow_back_24),
            contentDescription = "Go Back",
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
        )
        Text(
            text = "Go Back",
            fontSize = 20.sp,
            modifier = Modifier
                .clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
        )
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageName() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 124.dp)
    ) {
        GlideImage(
            model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            contentDescription = "sdf",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Text(
            text = "Person Name",
            fontSize = 32.sp
        )
    }
}

@Composable
fun Information(){
    Text(
        text = "Information",
        modifier = Modifier
            .padding(start = 24.dp, top = 370.dp),
        fontSize = 20.sp
    )
}

@Composable
fun DetailedInformation(){
    Column (
        modifier = Modifier.padding(start = 24.dp, top = 420.dp, end = 24.dp)
    ){

        Text(
            text = "Gender",
            fontSize = 16.sp
        )
        Text(
            text = "Hello!",
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)

        Text(
            text = "Status!",
            fontSize = 16.sp
        )
        Text(
            text = "Hello!",
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)

        Text(
            text = "Specie!",
            fontSize = 16.sp
        )
        Text(
            text = "Hello!",
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)

        Text(
            text = "Origin!",
            fontSize = 16.sp
        )
        Text(
            text = "Origin!",
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)

        Text(
            text = "Type!",
            fontSize = 16.sp
        )
        Text(
            text = "Type!",
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray)
    }
}
