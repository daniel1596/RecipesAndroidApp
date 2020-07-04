package com.example.recipesandroidapp

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.room.Room
import com.example.recipesandroidapp.dummy.DummyContent
import com.example.recipesandroidapp.room.Recipe
import com.example.recipesandroidapp.room.RecipeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: DummyContent.DummyItem? = null
    public var recipe: Recipe? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This didn't work but I'm trying to figure out when and how to call this loadDb() method
        GlobalScope.launch(Dispatchers.Main) {
            loadDb()
        }

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.content
            }
        }
    }

    suspend fun loadDb() {
        val db = Room.databaseBuilder(
                this.context!!.applicationContext,
                RecipeDatabase::class.java,
                "recipes")
            .createFromAsset("db/recipes.db")
            .build()

        // Some debugging statements to show that this is actually working! ... ish.
        // It's loading in the whole Recipe object! Only downside is... most likely onCreateVew()
        // is getting called first before this recipe runs. Dag.
        this.recipe = db.loadRecipeByName("Bean burgers")
        val x = this.recipe
        val y = x
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.findViewById<TextView>(R.id.item_detail).text = this.recipe?.Name
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}