package com.isil.am2.am2examplesqlite.view.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.isil.am2.am2examplesqlite.R;
import com.isil.am2.am2examplesqlite.model.entity.ContactEntity;
import com.isil.am2.am2examplesqlite.storage.db.CRUDOperations;
import com.isil.am2.am2examplesqlite.storage.db.MyDatabase;
import com.isil.am2.am2examplesqlite.view.listeners.OnHomeListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement theinterface
 * to handle interaction events.
 * Use the {@link AddContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHomeListener mListener;
    private ImageView iviUser;
    private EditText eteNombre,eteEmail,etePhone;
    private Button btnAdd;

    private ContactEntity contactEntity;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddContactFragment newInstance(String param1, String param2) {
        AddContactFragment fragment = new AddContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AddContactFragment() {
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
        return inflater.inflate(R.layout.fragment_add_contact, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        iviUser= (ImageView)getView().findViewById(R.id.iviUser);

        eteNombre= (EditText)getView().findViewById(R.id.eteNombre);
        eteEmail= (EditText)getView().findViewById(R.id.eteEmail);
        etePhone= (EditText)getView().findViewById(R.id.etePhone);
        btnAdd= (Button)getView().findViewById(R.id.btnAdd);

        //events
        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    addContact();
                }
            }
        });


    }

    private boolean validate()
    {
        String name= eteNombre.getText().toString().trim();
        String email= eteEmail.getText().toString().trim();
        String phone= etePhone.getText().toString().trim();

        if(name.isEmpty())
        {
            eteNombre.setError("Nombre incorrecto");
            return false;
        }
        if(email.isEmpty())
        {
            eteEmail.setError("Email incorrecto");
            return false;
        }
        if(phone.isEmpty())
        {
            etePhone.setError("Teléfono incorrecto");
            return false;
        }
        eteNombre.setError(null);
        eteEmail.setError(null);
        etePhone.setError(null);

        contactEntity= new ContactEntity(100,name,email,phone);

        Log.v("CONSOLE", " ContactEntity " + contactEntity.toString());

        return true;
    }

    private void addContact()
    {
        MyDatabase db = new MyDatabase(getActivity());
        CRUDOperations crud = new CRUDOperations(db);
        crud.addContact(contactEntity);

        mListener.listContacts();
    }
}
