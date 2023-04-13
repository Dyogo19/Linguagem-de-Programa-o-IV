package br.com.fundatec.fundatecheroes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import br.com.fundatec.fundatecheroes.R.string
import br.com.fundatec.fundatecheroes.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroes.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.example.module.components.showToast
import com.example.module.components.visible
import com.google.android.material.snackbar.Snackbar


class MainActivityHome: AppCompatActivity() {

    @SuppressLint("StringFormatInvalid")
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        val image = findViewById<ImageView>(R.id.logo)
        Glide
            .with(image.context)
            .load("https://e1.pngegg.com/pngimages/889/193/png-clipart-goku-son-goku-thumbnail.png")
            .into(image)

        binding.okButton.setOnClickListener {
            viewModel.validateName(binding.etName.text)
        }
        // Realizar o click através do xml utilizando viewbinging
        binding.clearButton.setOnClickListener {
            viewModel.clear()
        }
        // Mudar a visibilidade utilizando viewbinding, ou seja utilizando as variaveis direto no xml
        viewModel.visibility.observe(this@MainActivityHome) { visibility ->
            binding.tvHello.visibility = visibility
            binding.tvHello.visible()
        }

        viewModel.showToast.observe(this@MainActivityHome) {
            Snackbar.make(binding.container, "Preencha os campos!!!", Snackbar.LENGTH_LONG).apply {
                anchorView = binding.etName

            }.setAction("Desfazer") {
                showToast("Preencha os campos!!!")
            }.show()

        }

        @BindingAdapter(value = ["app:customVisibility"], requireAll = false)
        fun View.setVisibility(visibility: Boolean) {
            this.isVisible = visibility
        }

        @BindingAdapter(value = ["app:customText"], requireAll = false)
        fun TextView.setText(text: String?) {
            this.text = context.getString(R.string.hello, text)
        }

//        val etName = findViewById<EditText>(R.id.et_name)
//        val btOk = findViewById<Button>(R.id.ok_button)
//        val btClear = findViewById<Button>(R.id.clear_button)
//        val tvHello = findViewById<TextView>(R.id.tv_hello)
//
//        btOk.setOnClickListener {
//            viewModel.validateName(etName.text)
//
//        }
//
//        btClear.setOnClickListener {
//            viewModel.clear()
//        }
//
//        viewModel.publicName.observe(this) { name ->
//            tvHello.text = getString(string.Qual_nome, name)
//            //etName.setText(name)
//        }
//
//        viewModel.visibility.observe(this) { visibility ->
//            tvHello.visibility = visibility
//        }
//
//        viewModel.showToast.observe(this) {
//            Toast.makeText(this, "Preencha os campos!!!", Toast.LENGTH_LONG).show()
//        }

//        viewModel.delet.observe(this){
//            tvHello.
//
//        }

    }
}