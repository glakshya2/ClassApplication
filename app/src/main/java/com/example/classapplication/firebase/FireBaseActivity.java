package com.example.classapplication.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classapplication.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireBaseActivity extends AppCompatActivity {

    EditText nameET,prictET,quantityET,vendorET;
    Button addButton;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);
        tableLayout = findViewById(R.id.tableLayout);
        nameET = findViewById(R.id.productname);
        prictET =findViewById(R.id.productprice);
        quantityET=findViewById(R.id.productquantity);
        vendorET=findViewById(R.id.productvendor);
        addButton=findViewById(R.id.addproduct);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
        readData();
    }

    private void readData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.
                getReference("Product/");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tableLayout.removeViews(0,tableLayout.getChildCount());
                for (DataSnapshot ds:snapshot.getChildren()){
                    Product p=ds.getValue(Product.class);
                    TableRow row=new TableRow(FireBaseActivity.this);
                    TextView tvid=new TextView(FireBaseActivity.this);
                    TextView tvname=new TextView(FireBaseActivity.this);
                    TextView tvquantity=new TextView(FireBaseActivity.this);
                    TextView tvprice=new TextView(FireBaseActivity.this);
                    TextView tvvendor=new TextView(FireBaseActivity.this);
                    row.addView(tvid);tvid.setText(String.format("%d", p.getId()));
                    row.addView(tvname);tvname.setText(p.getName());
                    row.addView(tvprice);tvprice.setText(String.format("%s", p.getPrice()));
                    row.addView(tvquantity);tvquantity.setText(String.format("%d", p.getQuantity()));
                    row.addView(tvvendor);tvvendor.setText(p.getVendor());
                    tableLayout.addView(row);
                }
                for (int i=0;i<tableLayout.getChildCount();i++){
                    TableRow row=(TableRow) tableLayout.getChildAt(i);
                    row.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            TextView textView= (TextView) row.getChildAt(0);
                            DatabaseReference r= database.getReference("Product/"
                                    +textView.getText().toString());
                            r.removeValue();
                            Toast.makeText(getApplicationContext(),
                                    "Row is removed",
                                    Toast.LENGTH_LONG).show();
                            return true;
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    void addProduct(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.
                getReference("Product/"+Product.current_id);
        myRef.setValue(new Product(nameET.getText().toString(),
                vendorET.getText().toString(),
                Float.parseFloat(prictET.getText().toString()),
                Integer.parseInt(quantityET.getText().toString()),
                Product.current_id));
    }

}
class Product{
    static int current_id=0;
    String name,vendor;
    float price;
    int quantity,id;
    public Product(){
        //current_id++;
    }
    public Product(String name, String vendor, float price, int quantity,int id) {
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.quantity = quantity;
        this.id=id;
        current_id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}