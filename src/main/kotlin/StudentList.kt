import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

class StudentList {
    @Composable
    fun MainScreen() {
        val studentsState = remember { mutableStateListOf("Juan", "Victor", "Esther", "Jaime")}
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        ) {
            //Llama a la funcion pasandole los dos parametros
            StudentList(studentsState){ studentsState.add("Miguel") }
            //Otra forma de llamarla:
            //StudentList(studentsState,{ studentsState.add("Miguel") })
            //StudentList(studentsState){
                //studentsState.add("Miguel")
            //}
        }
    }

    @Composable
    fun StudentList(students: List<String>, onButtonClick: () -> Unit) {
        var cont = remember { mutableStateOf(2) } // Para acceder -> cont.value  ej: cont.value++ (el unico que se usa con var)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (student in students) {
                StudentText(name = student)
            }
            Button(
                onClick = onButtonClick,
            ) {
                Text(text = "Add new student")
            }
        }
    }

    @Composable
    fun StudentText(name: String) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(10.dp)
        )
    }
}