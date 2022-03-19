package com.roomexamples.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SomethingPage() {
    var somethingViewModel: SomethingViewModel = hiltViewModel()
    var flowList = somethingViewModel.flow.collectAsState(initial = listOf())
    var liveData = somethingViewModel.liveData.observeAsState(initial = listOf())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.85f)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth(.33f)
                    .fillMaxHeight()
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Column()
                {
                    Text("Flow", modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                    flowList.value.forEachIndexed { index, item ->
                        Text("$index ${item.id}")
                    }
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
            {
                Column()
                {
                    Text("LiveData", modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                    if (liveData.value != null) {
                        liveData.value!!.forEachIndexed { index, item ->
                            Text("$index ${item.id}")
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Yellow)
            )
            {
                Column()
                {
                    Text("List<Book>", modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
                    if (somethingViewModel.listOfBooks.value != null) {
                        somethingViewModel.listOfBooks.value!!.forEachIndexed { index, item ->
                            Text("$index ${item.id}")
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { somethingViewModel.insert() })
            { Text("Insert") }

            Button(onClick = {
                if (flowList.value != null && flowList.value.isNotEmpty())
                    somethingViewModel.delete(flowList.value.get(0).id)
            })
            { Text("Delete") }

            Button(onClick = { somethingViewModel.updateListOfBooks() })
            { Text("Update list manually") }
        }
    }
}