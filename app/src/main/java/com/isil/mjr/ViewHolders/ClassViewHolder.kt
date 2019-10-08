package pe.noblecilla.mjrlanguages.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.isil.mjr.R
import kotlinx.android.synthetic.main.layout_with_child.view.*
import org.w3c.dom.Text
import pe.noblecilla.mjrlanguages.Interfaces.ItemClickListener


class ClassViewHolder (itemView: View,isExpandable:Boolean):RecyclerView.ViewHolder(itemView){

    lateinit var txtClassText: TextView
    lateinit var txtClassChild: TextView
    lateinit var txtClassChild2: TextView
    lateinit var txtClassChild3: TextView
    lateinit var button: RelativeLayout
    lateinit var expandableLayout: ExpandableLinearLayout

    lateinit var iitemClickListener: ItemClickListener

    fun setItemClickListener(iitemClickListener: ItemClickListener){
        this.iitemClickListener = iitemClickListener
    }
    init {
        if (isExpandable){
            txtClassText = itemView.findViewById(R.id.txtClassItem) as TextView
            txtClassChild = itemView.findViewById(R.id.txtClassItem_child) as TextView
            txtClassChild2 = itemView.findViewById(R.id.txtClassItem_child2) as TextView
            txtClassChild3 = itemView.findViewById(R.id.txtClassItem_child3) as TextView

            button = itemView.findViewById(R.id.button) as RelativeLayout

            expandableLayout = itemView.findViewById(R.id.ELClass) as ExpandableLinearLayout
        }else{
            txtClassText = itemView.findViewById(R.id.txtClassItem) as TextView
        }

        itemView.setOnClickListener { view -> iitemClickListener.onClick(view,adapterPosition)}
    }
}