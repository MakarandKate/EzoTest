package `in`.co.ezotest.view.adapter

import `in`.co.ezotest.BR
import `in`.co.ezotest.R
import `in`.co.ezotest.data.model.Author
import `in`.co.ezotest.databinding.ViewAuthorBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class AuthorAdapter(
    private var authorList: List<Author>
) : RecyclerView.Adapter<AuthorAdapter.ViewHolder>() {

    private lateinit var authorAdapter: AuthorAdapter

    override fun getItemCount(): Int {
        return authorList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorAdapter.ViewHolder {
        authorAdapter = this
        val binding: ViewAuthorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.view_author, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorAdapter.ViewHolder, position: Int) {
        val item = authorList[position]
        holder.bind(item)
    }

    open inner class ViewHolder(private val viewAuthorBinding: ViewAuthorBinding)
        : RecyclerView.ViewHolder(viewAuthorBinding.root) {
        fun bind(author: Author) {
            viewAuthorBinding.setVariable(BR.data, author)
            viewAuthorBinding.setVariable(BR.adapter, authorAdapter)
            viewAuthorBinding.executePendingBindings()
        }
    }

    // SHOW '${id}: ${author}' TOAST WHEN CLICKED ON CARD.
}