package com.computernerd1101.imageheader.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.computernerd1101.imageheader.R
import com.computernerd1101.imageheader.databinding.FragmentScrollingBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_scrolling.*

class MainFragment : Fragment() {

    companion object {
        @Suppress("unused")
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentScrollingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_scrolling, container, false
        )
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = viewModel
        viewModel.floatingActionClicked.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                viewModel.floatingActionDone()
            }
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = this.activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_scrolling, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
