package com.jes.wikiworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.jes.wikiworld.databinding.ActivityCreditBinding
import com.jes.wikiworld.databinding.FragmentCreditBinding

class CreditActivity : AppCompatActivity() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val ARG_USER_NAME = "userName"

        fun newInstance(userName: String): CreditFragment {
            val fragment = CreditFragment()
            val args = Bundle().apply {
                putString(ARG_USER_NAME, userName)
            }
            fragment.arguments = args
            return fragment
        }
    }

        fun newInstance(userName: String): CreditFragment {
            val fragment = CreditFragment()
            val args = Bundle().apply {
                putString(ARG_USER_NAME, userName)
            }
            fragment.arguments = args
            return fragment
        }

    }
