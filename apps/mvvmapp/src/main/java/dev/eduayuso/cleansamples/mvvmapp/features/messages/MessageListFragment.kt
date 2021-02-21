package dev.eduayuso.cleansamples.mvvmapp.features.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.eduayuso.cleansamples.mvvmapp.R

class MessageListFragment : Fragment() {

    //private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)*/
        val root = inflater.inflate(R.layout.fragment_message_list, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}