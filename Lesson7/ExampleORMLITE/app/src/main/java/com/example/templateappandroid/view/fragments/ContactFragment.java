package com.example.templateappandroid.view.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.templateappandroid.R;
import com.example.templateappandroid.model.entity.ContactEntity;
import com.example.templateappandroid.storage.db.ContactRepository;
import com.example.templateappandroid.storage.db.DatabaseHelper;
import com.example.templateappandroid.view.adapters.ContactAdapter;
import com.example.templateappandroid.view.listeners.OnHomeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link com.example.templateappandroid.view.fragments.ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHomeListener mListener;
    private ListView lviContact;
    private View header;

    private DatabaseHelper mhelper;
    private ContactRepository contactRepository;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnHomeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lviContact= (ListView)getView().findViewById(R.id.lviContact);
        header= getView().findViewById(R.id.header);

        List<ContactEntity> data = new ArrayList<ContactEntity>();

	    /*ContactEntity entity1= new ContactEntity( "Eduardo", "abc@abc.com", "4575488");
		ContactEntity entity2= new ContactEntity( "Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity3= new ContactEntity( "Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity4= new ContactEntity("Eduardo",  "abc@abc.com", "4575488");
		ContactEntity entity5= new ContactEntity("Eduardo",  "abc@abc.com", "4575488");

		mhelper.addContactData(entity1);
		mhelper.addContactData(entity2);
		mhelper.addContactData(entity3);
		mhelper.addContactData(entity4);
		mhelper.addContactData(entity5);*/

        mhelper=new DatabaseHelper(getActivity());
        data= mhelper.getContactAll();

        //contactRepository= new ContactRepository(getActivity());
        //data= contactRepository.getAll();

        ContactAdapter contactAdapter= new ContactAdapter(getActivity(),data);
        lviContact.setAdapter(contactAdapter);

        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //TODO agregar nuevo contacto
                mListener.addContact(null);
            }
        });

        lviContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactEntity entity= (ContactEntity)adapterView.getAdapter().getItem(i);
                Log.v("CONSOLE", "entity "+entity.toString());

                mListener.selectedContact(entity);
            }
        });
    }
}
