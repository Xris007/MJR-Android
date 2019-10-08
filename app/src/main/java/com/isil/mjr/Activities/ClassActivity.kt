package com.isil.mjr.Activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter
import com.github.aakira.expandablelayout.Utils
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_class.*
import pe.noblecilla.mjrlanguages.Interfaces.ItemClickListener
import pe.noblecilla.mjrlanguages.ViewHolders.ClassViewHolder
import java.util.ArrayList


class ClassActivity : AppCompatActivity() {

    internal var classes: MutableList<com.isil.mjr.Classes.Class> = ArrayList()
    internal lateinit var adapter: FirebaseRecyclerAdapter<com.isil.mjr.Classes.Class, ClassViewHolder>

    internal var expandState = SparseBooleanArray()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        RVClass.setHasFixedSize(true)
        RVClass.layoutManager = LinearLayoutManager(this)

        //retornar datos de BD
        retrieveData()
        //colocar los datos
        setData()

        ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }



        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddClassActivity::class.java))
        }
    }

    private fun setData()  {
        val query = FirebaseDatabase.getInstance().reference.child("Class")
        val options = FirebaseRecyclerOptions.Builder<com.isil.mjr.Classes.Class>()
            .setQuery(query,com.isil.mjr.Classes.Class::class.java)
            .build()



        adapter = object:FirebaseRecyclerAdapter<com.isil.mjr.Classes.Class, ClassViewHolder>(options){

            override fun getItemViewType(position: Int): Int {
                return if(classes[position].isExpandable)
                    1
                else
                    0

            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
                if(viewType == 0){
                    val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.layout_without_child,parent,false)
                    return ClassViewHolder(itemView, viewType == 1)
                }else{
                    val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.layout_with_child,parent,false)
                    return ClassViewHolder(itemView, viewType == 1)
                }
            }

            override fun onBindViewHolder(holder: ClassViewHolder, position: Int, model: com.isil.mjr.Classes.Class) {
                when(holder.itemViewType){
                    0 ->{
                        holder.setIsRecyclable(false)
                        holder.txtClassText.text = model.Name

                        holder.setItemClickListener(object: ItemClickListener {
                            override fun onClick(view: View, position: Int) {
                                Toast.makeText(
                                    this@ClassActivity,
                                    "" + model.Name,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        })
                    }
                    1 ->{
                        holder.setIsRecyclable(false)
                        holder.txtClassText.text = model.Name

                        holder.setItemClickListener(object: ItemClickListener {
                            override fun onClick(view: View, position: Int) {
                                Toast.makeText(
                                    this@ClassActivity,
                                    "" + model.Name,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        })

                        holder.expandableLayout.setInRecyclerView(true)
                        holder.expandableLayout.isExpanded = expandState.get(position)
                        holder.expandableLayout.setListener(object: ExpandableLayoutListenerAdapter(){
                            override fun onPreOpen() {
                                changeRotate(holder.button,0f,180f).start()
                                expandState.put(position,true)
                            }

                            override fun onPreClose() {
                                changeRotate(holder.button,180f,0f).start()
                                expandState.put(position,false)
                            }
                        })

                        holder.button.rotation = if (expandState.get(position)) 180f else 0f
                        holder.button.setOnClickListener {
                            holder.expandableLayout.toggle()
                        }

                        holder.txtClassChild.text = model.Teacher
                        holder.txtClassChild2.text = model.Lesson
                        holder.txtClassChild3.text = model.Comment

                    }
                }
            }

        }

        expandState.clear()
        for (i in classes.indices)
            expandState.append(i,false)
        RVClass.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        RVClass.adapter = adapter
    }

    private fun changeRotate(button: RelativeLayout, from: Float, to: Float): ObjectAnimator {
        val animator = ObjectAnimator.ofFloat(button,"rotation",from,to)
        animator.duration = 300
        animator.interpolator = Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR)
        return animator
    }

    private fun retrieveData() {
        classes.clear()

        val bd = FirebaseDatabase.getInstance().reference.child("Class")

        bd.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("ERROR", "" + p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (itemSnapShot in p0.children){
                    val item = itemSnapShot.getValue(com.isil.mjr.Classes.Class::class.java)

                    classes.add(item!!)
                }
            }

        })
    }

    override fun onStart() {
        super.onStart()
        if (adapter != null)
            adapter.startListening()
    }

    override fun onStop() {
        if (adapter != null)
            adapter.stopListening()
        super.onStop()
    }

    override fun onBackPressed() {

    }
}
