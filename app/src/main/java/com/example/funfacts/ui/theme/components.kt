package com.example.funfacts.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.TextUtilsCompat
import androidx.core.widget.TextViewCompat.AutoSizeTextType
import com.example.funfacts.Data.UserDateUiEvents
import com.example.funfacts.R

@Composable
fun Topbar(value: String) {
Row (
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically

) {
    Text(
        text = value,
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold

    )
    Spacer(modifier = Modifier.weight(1f))
    Image(
        modifier = Modifier.size(80.dp),
        painter = painterResource(id = R.drawable.logo),
         contentDescription = "Native Mobile Bits" )
}
}

@Preview(showBackground = true)
@Composable
fun Topbarpreview() {
   Topbar("")
}

@Composable
fun TextComponent(
    textValue:String,
    textsize: TextUnit ,
    colorvalue: Color= Color.Black)
{
    Text(text = textValue,
       fontSize = textsize,
        color = colorvalue,
        fontWeight = FontWeight.Normal
        )


}

@Preview(showBackground = true)
@Composable
fun Textcomponentspreview() {
    TextComponent(textValue = "Native Mobile Bits",
        textsize =24.sp )
}
@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged :(name:String) -> Unit
) {
    var currentvalue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
OutlinedTextField(
    modifier = Modifier.fillMaxWidth(),
    value =  currentvalue ,
    onValueChange = {
        currentvalue =it
                    onTextChanged(it)
    },
    placeholder = {
Text(text = "Enter your name", fontSize = 18.sp)
    },
    textStyle = TextStyle.Default.copy(fontSize = 24.sp),
    keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Done
    ),
    keyboardActions = KeyboardActions{
        localFocusManager.clearFocus()

    }
)


}

@Preview
@Composable
fun TextFieldComponentpreview() {
TextFieldComponent()
}

fun TextFieldComponent() {
    TODO("Not yet implemented")
}

@Composable
fun AnimalCard(image: Int, selected: Boolean,
               animalSelecter :(animalNane:String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current

    Card (
        shape = RoundedCornerShape(8.dp),

                modifier = Modifier
                    .padding(24.dp)
                    .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Box (
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {


        Image(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .clickable {
                    val animalNane = if (image == R.drawable.catlogo) "cat" else "Dog"
                    animalSelecter(animalNane)
                    localFocusManager.clearFocus()
                },
            painter = painterResource(id = image ) ,
            contentDescription = "Animal Image")

        }

    }

}

@Preview
@Composable
fun AnimalCardpreview() {
AnimalCard(R.drawable.catlogo, false, {"Dog"}
)
}

@Composable
fun ButtonComponenent(
    goToDetailsScreen : () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { goToDetailsScreen()
        /*TODO*/ }) {
        TextComponent(textValue = "Got to Detail screen",
            textsize = 18.sp
        , colorvalue = Color.White
        )


    }
}

@Composable
fun TextWidthShadow(value: String) {
    val shadowoffset = Offset(x=1f,y=2f)
    Text(text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(),shadowoffset,2f )
        )
    )

}
