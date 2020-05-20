package lab.chevalier.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import lab.chevalier.navigationexample.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

        binding.btnAction.setOnClickListener { check() }

        return binding.root
    }

    private fun check(){
        if (binding.edNama.text.isEmpty()) Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
        else action()
    }

    private fun action(){
        requireView().findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(binding.edNama.text.toString()))
    }

}
