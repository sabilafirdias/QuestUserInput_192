import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prak5.R

@Composable
fun FormPendaftaran (modifier: Modifier){
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}
    var status by remember {mutableStateOf("")}

    val gender:List<String> = listOf("Laki-laki", "Perempuan")
    val kawin:List<String> = listOf("Single", "Taken", "HTS")

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(top = 30.dp)
                .background(colorResource(id = R.color.hijautua))){
                Text(
                    text = "Formulir Pendaftaran",
                    fontSize = 29.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding (top = 40.dp, start = 9.dp)
                )
        }
        Spacer(modifier = Modifier.height(16.dp))

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.hijaumuda)),
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(all = 12.dp)) {

            Text(
                text = "NAMA LENGKAP",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 9.dp, start = 9.dp)
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                label = { Text(text = "Isian nama lengkap") },
                onValueChange = {
                    textNama = it
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "JENIS KELAMIN",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 9.dp, start = 9.dp)
            )

            Column {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                        selected = textJK == item,

                        onClick = { textJK = item }
                    ), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = textJK == item,

                            onClick = {
                                textJK = item
                            })
                        Text(item)
                    }
                }
            }

            Text(
                text = "STATUS KAWIN",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 9.dp, start = 9.dp)
            )
            Column {
                kawin.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                        selected = textStatus == item,
                        onClick = { textStatus = item }
                    ), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = textStatus == item,
                            onClick = {
                                textStatus = item
                            })
                        Text(item)
                    }
                }
            }

        }
    }
}