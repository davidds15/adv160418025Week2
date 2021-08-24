package id.ac.ubaya.infor.adv160418025week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    var number1 = 0
    var number2 = 0
    var ans = 0
    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    fun initialize(){
        number1 = Random.nextInt(0, 100)
        txtNumber1.text = number1.toString()
        number2 = Random.nextInt(0, 100)
        txtNumber2.text = number2.toString()
        ans = number1 + number2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's turn"
        }
//        btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
        initialize()
        btnSubmit.setOnClickListener {
            if(txtAnswer.text.toString() != ans.toString()){
                val action = GameFragmentDirections.actionToResult(score)
                Navigation.findNavController(it).navigate(action)
            }else{
                score += 1
                txtAnswer.setText("")
                initialize()
            }
        }

    }
}