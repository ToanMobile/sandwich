/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.sandwichdemo.coroutines

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.skydoves.sandwichdemo.R
import com.skydoves.sandwichdemo.adapter.PosterAdapter
import com.skydoves.sandwichdemo.databinding.ActivityMainCoroutinesBinding

class MainCoroutinesActivity : AppCompatActivity() {

  private val viewModelFactory: MainCoroutinesViewModelFactory = MainCoroutinesViewModelFactory()
  private val viewModel: MainCoroutinesViewModel by lazy {
    ViewModelProvider(this, viewModelFactory).get(MainCoroutinesViewModel::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DataBindingUtil.setContentView<ActivityMainCoroutinesBinding>(this, R.layout.activity_main_coroutines).apply {
      lifecycleOwner = this@MainCoroutinesActivity
      viewModel = this@MainCoroutinesActivity.viewModel
      adapter = PosterAdapter()
    }

    viewModel.toastLiveData.observe(
      this,
      {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
      }
    )
  }
}
