package com.example.xpertgroupprueba.ui.vote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.Adapters.VoteAdapter;
import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.VoteModel;
import com.example.xpertgroupprueba.model_view.VoteViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VoteFragment extends Fragment {
    private VoteViewModel mVoteViewModel;
    private RecyclerView voteRecyclerView;
    VoteAdapter voteAdapter;
    View emptyLayout;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mVoteViewModel = new ViewModelProvider(this).get(VoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vote, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        voteRecyclerView= (RecyclerView) getActivity().findViewById(R.id.voteRecyclerView);
        voteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        voteRecyclerView.setHasFixedSize(true);
        voteAdapter = new VoteAdapter();
        emptyLayout = getActivity().findViewById(R.id.empty);
        voteRecyclerView.setAdapter(voteAdapter);
        mVoteViewModel.getAllvotes().observe(getActivity(), new Observer<List<VoteModel>>() {
            @Override
            public void onChanged(List<VoteModel> voteModels) {
                voteAdapter.setList(voteModels);
                if (voteAdapter.getItemCount() == 0){
                    emptyLayout.setVisibility(View.VISIBLE);
                    voteRecyclerView.setVisibility(View.GONE);
                }else{
                    emptyLayout.setVisibility(View.GONE);
                    voteRecyclerView.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}