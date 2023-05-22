package dev.mlds.wallettest.ui.resume

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.mlds.wallettest.R
import dev.mlds.wallettest.domain.models.CardModel
import dev.mlds.wallettest.ui.create.CreateFragment
import dev.mlds.wallettest.ui.theme.WalletLigthTheme

class ResumeFragment : Fragment() {

    private var card: CardModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        card = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(CreateFragment.CREATE_DATA, CardModel::class.java)
        } else {
            arguments?.getParcelable(CreateFragment.CREATE_DATA) as? CardModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WalletLigthTheme {
                    ResumeScreen(
                        card,
                        backClick = ::backClick,
                        nextPage = ::nextPage
                    )
                }
            }
        }
    }
    private fun nextPage() {
        findNavController().navigate(R.id.nav_to_splash)
    }

    private fun backClick() {
        findNavController().popBackStack()
    }
}