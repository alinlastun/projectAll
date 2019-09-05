package com.softvision.hope.showcase.ui.test

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.softvision.hope.base.mvi.*
import com.softvision.hope.base.ui.BaseFragment

import com.softvision.hope.showcase.R
import kotlinx.android.synthetic.main.fragment_showcase_test.*

class TestShowcaseFragment : BaseFragment(), StateConsumer<TestShowcaseState>,
IntentProducer<TestShowcaseIntent> by ChannelIntentProducer() {
    override val contentLayoutResource = R.layout.fragment_showcase_test

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel(TestShowcaseViewModel::class)

        btn.setOnClickListener{
          intent(TestShowcaseIntent.ButtonClickedIntent)
        }

    }
    override fun consume(state: TestShowcaseState) {
        with (state) {
            // do something with state
           if(state.someData == "Button clicked" ) {
               findNavController().navigate(R.id.action_testFragment_to_newTestFragment)
               state.copy(
                   someData = ""
               )
           }
        }
    }
}
