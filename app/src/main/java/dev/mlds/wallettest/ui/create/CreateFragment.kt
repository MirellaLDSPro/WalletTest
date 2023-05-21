package dev.mlds.wallettest.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.mlds.wallettest.R
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

class CreateFragment : Fragment() {

    companion object {
        const val CREATE_DATA = "CREATE_DATA"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WalletLigthTheme {
                    CardCreateScreen(backClick = ::backClick, nextPage = ::nextPage)
                }
            }
        }
    }

    private fun nextPage(bundle: Bundle) {
//        findNavController().navigate(R.id.action_createCardFragment_to_resumeFragment, bundle)
    }

    private fun backClick() {
        findNavController().popBackStack()
    }
}