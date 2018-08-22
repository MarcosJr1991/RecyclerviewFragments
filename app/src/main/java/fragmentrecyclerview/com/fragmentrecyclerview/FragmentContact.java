package fragmentrecyclerview.com.fragmentrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

   View v;
   private RecyclerView myrecyclerview;
   private List<Contact> lstContact;

   public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       v=inflater.inflate(R.layout.contact_fragment,container,false);
       myrecyclerview =(RecyclerView)v.findViewById(R.id.contact_recyclerview);
       RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstContact);
       myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
       myrecyclerview.setAdapter(recyclerViewAdapter);
       return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));
        lstContact.add(new Contact("Marcos Junior ","(11) 1234 - 5678",R.drawable.mjr1));

    }
}
