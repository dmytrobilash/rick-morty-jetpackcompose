package com.dmytrobilash.rickmortyapijetpackcompose

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dmytrobilash.rickmortyapijetpackcompose.model.model.ResponseMain
import com.dmytrobilash.rickmortyapijetpackcompose.ui.theme.RickMortyApiJetpackComposeTheme
import com.dmytrobilash.rickmortyapijetpackcompose.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = MainViewModel()
        Log.v("TAG",  vm.listResponse.toString())
        setContent {
            RickMortyApiJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TopPattern()
                        PersonList(personList = vm.listResponse)
                    }
                }
            }
        }
    }
}

@Composable
fun TopPattern(){

    Spacer(modifier = Modifier.height(92.dp))

    Image(
        painterResource(R.drawable.rick_mortyjpg),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 0.dp, 24.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(48.dp))

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.padding(24.dp, 0.dp, 24.dp, 12.dp),
        label = { Text("Filter by name...") },
        leadingIcon = { Icon(Icons.Filled.Search, "contentDescription") }
    )
}


@Composable
fun PersonList(personList: List<ResponseMain>){
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {

        itemsIndexed(items = personList) { index, item ->
            personItem(person = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun personItem(person: ResponseMain, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
    val context = LocalContext.current

    Card(
        onClick = {
            val intent = Intent(context, DetailedPersonInformation::class.java)
            context.startActivity(intent) },
        modifier = Modifier
            .padding(24.dp, 40.dp, 24.dp, 0.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(8.dp)

    ) {
        Surface{
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
            ) {
                GlideImage(
                    model = person.image,
                    contentDescription = "PersonDescription",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )
                Box(
                    modifier = Modifier
                    .padding(24.dp, 8.dp, 24.dp, 8.dp)
                ){
                    Column{
                        Text(
                            text = person.name ?: "",
                            fontSize = 20.sp,
                        )
                        Text(
                            text = person.species ?: "",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

