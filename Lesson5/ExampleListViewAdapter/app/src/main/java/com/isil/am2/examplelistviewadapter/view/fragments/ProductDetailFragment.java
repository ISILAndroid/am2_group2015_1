package com.isil.am2.examplelistviewadapter.view.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.am2.examplelistviewadapter.R;
import com.isil.am2.examplelistviewadapter.model.entity.ProductEntity;
import com.isil.am2.examplelistviewadapter.view.listeners.OnProductListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnProductListener mListener;
    private TextView tviName,tviPrice,tviModel,tviStock;
    private ImageView iviProduct;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetailFragment newInstance(String param1, String param2) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductDetailFragment() {
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
        return inflater.inflate(R.layout.fragment_product_detail, container, false);
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

        tviName = (TextView)getView().findViewById(R.id.tviName);
        tviPrice= (TextView)getView().findViewById(R.id.tviPrice);
        tviModel= (TextView)getView().findViewById(R.id.tviModel);
        tviStock=(TextView)getView().findViewById(R.id.tviStock);
        iviProduct=(ImageView)getView().findViewById(R.id.iviProduct);


    }
    public void showProductDetail(ProductEntity productEntity)
    {
        String name= productEntity.getName();
        String model= productEntity.getModel();
        String price= "$ "+productEntity.getPrice();
        String stock= (productEntity.isStock())?("Disponible"):("No disponible");

        tviName.setText(name);
        tviModel.setText(model);
        tviPrice.setText(price);
        tviStock.setText(stock);
    }



}
