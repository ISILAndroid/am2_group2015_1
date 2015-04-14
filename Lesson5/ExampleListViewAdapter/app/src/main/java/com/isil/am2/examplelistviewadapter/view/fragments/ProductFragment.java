package com.isil.am2.examplelistviewadapter.view.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.isil.am2.examplelistviewadapter.R;
import com.isil.am2.examplelistviewadapter.model.entity.ProductEntity;
import com.isil.am2.examplelistviewadapter.model.entity.UserEntity;
import com.isil.am2.examplelistviewadapter.view.adapters.ProductAdapter;
import com.isil.am2.examplelistviewadapter.view.adapters.UserAdapter;
import com.isil.am2.examplelistviewadapter.view.listeners.OnProductListener;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnProductListener mListener;
    private ListView lviProduct;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductFragment() {
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
        return inflater.inflate(R.layout.fragment_product, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnProductListener) activity;
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

        lviProduct= (ListView)getView().findViewById(R.id.lviProduct);
        ProductEntity[] data = new ProductEntity[]{
                new ProductEntity(100,"Cámara Digital", "NK1032",true,300.0f),
                new ProductEntity(101,"Producto de Prueba", "NK1030",false,200.0f),
                new ProductEntity(102,"Cámara Digital", "NK1050",true,400.0f),
                new ProductEntity(103,"Producto de Prueba", "NK1000",true,250.0f),
                new ProductEntity(103,"Producto de Prueba", "NK1000",true,300.0f),
                new ProductEntity(103,"Producto de Prueba", "NK1000",true,100.0f),
                new ProductEntity(103,"Producto de Prueba", "NK1000",true,400.0f)
        };

        ProductAdapter adapter = new ProductAdapter(getActivity(), R.layout.row_product, Arrays.asList(data));
        lviProduct.setAdapter(adapter);

        //events
        lviProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {

                ProductEntity entity= (ProductEntity)adapterView.getAdapter().getItem(position);
                mListener.productSelected(entity);
            }
        });

    }
}
