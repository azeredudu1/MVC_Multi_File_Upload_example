package net.viralpatel.spring3.controller;

import java.util.ArrayList;
import java.util.List;

import net.viralpatel.spring3.form.FileUploadForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping( value = "/show", method = RequestMethod.GET )
    public String showForm() {
        return "file_upload_form";
    }

    @RequestMapping( value = "/save", method = RequestMethod.POST )
    public String upload( @ModelAttribute( "uploadForm" ) FileUploadForm uploadForm, Model model ) {
        List<MultipartFile> files = uploadForm.getFiles();
        List<String> filenames = new ArrayList<String>();
        if ( files != null && files.size() > 0 ) {

            for ( MultipartFile file : files ) {
                String fileName = file.getOriginalFilename();
                filenames.add( fileName );
            }
        }
        model.addAttribute( "file", filenames );
        return "file_upload_success";

    }
}
