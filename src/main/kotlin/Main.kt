import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun Usuario(
    usuario: String,
    onEsribir: (String) -> Unit
){
    OutlinedTextField(
        // Lo q imprime
        value = usuario,
        // Cada vez que cambie (al pulsar una tecla por ej)
        onValueChange = onEsribir,
        modifier = Modifier
            .padding(bottom = 10.dp),
        label = { Text("Usuario") },
    )
}

@Composable
@Preview
fun Contrasenia(
    contrasenia: String,
    onChanguePass: (String) -> Unit,
    contraseniaVisible: Boolean,
    onVisPasswdChange: (Boolean) -> Unit
){
    OutlinedTextField(
        value = contrasenia,
        onValueChange = onChanguePass,
        label = { Text("Contraseña") },
        // Muestra la contraseña como *** cuando modo visible este en OFF
        visualTransformation = if(!contraseniaVisible) PasswordVisualTransformation() else VisualTransformation.None,
        // Icono para mostrar o dejar de mostrar contraseña
        trailingIcon = {
            IconToggleButton(
                checked = contraseniaVisible,
                onCheckedChange = onVisPasswdChange
            ){
                // Crear icono
                Icon(
                    // Depende de true o flase, muestra un icono o otro
                    imageVector = if (contraseniaVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "Pass")
            }
        }
    )
}

@Composable
@Preview
fun BotonLogin(
    botonActivado: Boolean,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        enabled = botonActivado
    ){
        Text(
            text = "Login"
        )
    }
}




@Composable
@Preview
fun App() {
    //val count = remember { mutableStateOf(0) }

    // Variables que guardan estados
    var usuario by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var contraseniaVisible by remember { mutableStateOf(false) }
    val botonActivado = usuario.isNotEmpty() && contrasenia.isNotEmpty()

    MaterialTheme {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            //Otra forma: verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),

        ){

            Usuario(usuario) { usuario = it }

            Contrasenia(contrasenia, {contrasenia = it}, contraseniaVisible) { contraseniaVisible = it }

            BotonLogin(botonActivado) { usuario = ""; contrasenia = "" }
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Log-in") {
        App()
    }
}


/** Opciones de OutlineTextFiled
 * fun OutlinedTextField(
 *     value = "",
 *     onValueChange = { },
 *     modifier = Modifier,
 *     enabled = true,
 *     readOnly = true,
 *     textStyle = TextStyle(),
 *     label = { }, --> Se nmuestra de fondo y cuando se escribe algo se sube arriba
 *     placeholder = { }, --> Se muesrta de fondo hasta que se escribe algo y se quita completamente
 *     leadingIcon = { },
 *     trailingIcon = { },
 *     isError = true,
 *     visualTransformation = PasswordVisualTransformation(),
 *     keyboardOptions = KeyboardOptions(),
 *     keyboardActions = KeyboardActions(),
 *     singleLine = true,
 *     maxLines = 1,
 *     minLines = 1,
 *     interactionSource = MutableInteractionSource(),
 *     shape = RoundedCornerShape(),
 *     colors = TextFieldDefaults.textFieldColors()
 *         )
 */