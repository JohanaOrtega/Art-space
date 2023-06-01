package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // es un contenedor visual que ocupa todo el
                //  espacio disponible en la actividad.
                //  Aquí se utiliza para envolver el composable
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    ArtSpaceApp()
                }
            }
        }
    }
}
//interfaz de usuario de manera declarativa.
@Composable
fun ArtImageWithTitle(imageResource: Int,  textResource: String, titleResource: String) {
//Se crea un Column composable que organiza los
// elementos secuencialmente en una columna vertical.
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = imageResource), contentDescription = null,
        //modificaciones del composeible
            modifier = Modifier.padding(20.dp)
            .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
            .height(350.dp)
            .width(300.dp).shadow(elevation = 4.dp, shape = RectangleShape).padding(20.dp))
//Se agrega un Card composable que representa una tarjeta visual.
        Card(modifier = Modifier.padding(horizontal = 20.dp, vertical = 100.dp), elevation = 6.dp,) {
//Se crea otro Column composable para organizar los elementos dentro de la tarjeta.
            Column(modifier = Modifier.padding(16.dp)) {
//Se agrega un Text composable para mostrar el título. text establece el texto a mostrar
                Text(
                    text = titleResource,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = textResource,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

@Composable
fun ArtSpaceApp() {
// un estado mutable y se inicializa con el valor 0.
    var result by remember {
        mutableStateOf(0)
    }
    when (result) {
//se manda a llamar la imagen con su texto
        1 -> ArtImageWithTitle(imageResource = R.drawable.bourgeois, textResource = stringResource(
            id = R.string.LouiseBourgeois), titleResource = stringResource(id = R.string.TBourgeois))

        2-> ArtImageWithTitle(imageResource = R.drawable.hockney, textResource = stringResource(
            id = R.string.DavidHockney), titleResource = stringResource(id = R.string.THockney))

        3 -> ArtImageWithTitle(imageResource = R.drawable.koons, textResource = stringResource(
            id = R.string.JeffKoons), titleResource = stringResource(id = R.string.TKoons))

        4 -> ArtImageWithTitle(imageResource = R.drawable.imagechristina, textResource = stringResource(
            id = R.string.AndrewWyeth), titleResource = stringResource(id = R.string.TWyeth))

        5 -> ArtImageWithTitle(imageResource = R.drawable.lovers, textResource = stringResource(
            id = R.string.RenéMagritte), titleResource = stringResource(id = R.string.TMagritte))

        else -> ArtImageWithTitle(imageResource = R.drawable.memorysalvordali, textResource = stringResource(
            id = R.string.SalvadorDalí), titleResource = stringResource(id = R.string.TDalí))
    }
//Se crea un Row composable que organiza los elementos secuencialmente en una fila horizontal.
    Row(horizontalArrangement = Arrangement.spacedBy(0.dp,alignment = Alignment.CenterHorizontally),
    verticalAlignment = Alignment.Bottom,
    modifier = Modifier.padding(bottom = 30.dp)) {
        
        Button(onClick = { result-- },
            modifier = Modifier.padding(start = 50.dp, end = 50.dp)) {
            Text(text = "Previous")
        }
        
        Button(onClick = { result++ },
            modifier = Modifier.padding(20.dp,0.dp,20.dp,0.dp)) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {

        ArtSpaceApp()
    }
}