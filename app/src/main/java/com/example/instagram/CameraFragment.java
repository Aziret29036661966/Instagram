package com.example.instagram;
import static android.app.Activity.RESULT_OK;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.instagram.databinding.FragmentCameraBinding;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
public class CameraFragment extends Fragment{
    private FragmentCameraBinding binding;
    File directory;
    private Uri outputFileUri;
    ActivityResultLauncher<Intent> someActivityResultLauncher;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCameraBinding.inflate(inflater);
        // forMyPhoto();
        //itsForPhoto();
        //itsForVideo();
        takePictureFromGalleryOrAnyOtherFolder();
        createDirectory();
        getImages();
        return binding.getRoot();
    }
    private void forMyPhoto() {
        someActivityResultLauncher = registerForActivityResult
                (new ActivityResultContracts.StartActivityForResult(), result -> {
                    Bundle extras = result.getData().getExtras();
                    Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
                    binding.ivPhoto.setImageURI(outputFileUri);
                });
    }

    private void takePictureFromGalleryOrAnyOtherFolder(){
        binding.btnPhoto.setOnClickListener(view -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            activityResultLauncher.launch(photoPickerIntent);
        });
    }
    public void itsForPhoto() {
        binding.btnPhoto.setOnClickListener(view -> {
            Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            someActivityResultLauncher.launch(intent1);
        });
    }
    public void getImages() {
activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
    if (result.getResultCode() == RESULT_OK) {
        try {
            final Uri imageUri = result.getData().getData();
            final InputStream imageStream = requireActivity().getContentResolver().openInputStream(imageUri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            binding.ivPhoto.setImageBitmap(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(requireActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }else {
        Toast.makeText(requireActivity(), "You haven't picked Image", Toast.LENGTH_LONG).show();
    }
});
    }
    public void itsForVideo() {
        binding.btnVideo.setOnClickListener(view -> {
            Intent intent1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            someActivityResultLauncher.launch(intent1);
        });
    }
    private void createDirectory() {
        directory = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "MyFolder");
        if (!directory.exists())
            directory.mkdirs();
    }
}