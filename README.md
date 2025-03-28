# **TravelBudd** 🌍📸  

Share your favorite clicks with others to cherish together. A seamless wallpaper download app where you can choose from lovely uploaded wallpapers of your favorite places shared by the community.  

---

## ***Project Roadmap:*** 🛣️  

### **Commit 1 - Fetched images locally 🖼️**  
- Imported the images into the drawable directory.
- Designed a basic interface to load the images.
- Implemented functionality to load images which we stored in the file directory.    
- Ensured smooth performance by handling images efficiently in loop to wrap aroun the images in the end.  

### **Commit 2 - Fetched images from Google using Glide 🌐📷**  
- Integrated the `Glide` library to fetch and display images from the internet.  
```
implementation("com.github.bumptech.glide:glide:4.16.0")
kapt("com.github.bumptech.glide:compiler:4.16.0")
```
- Getting the image statistically ussing url
```
 Glide.with(this)
             .load("https://static2.tripoto.com/media/filter/nl/img/1649149/TripDocument/1568134333_9_view_of_the_bada_imambara_complex.jpg.webp48622")
             .into(mainImage)
```  

### **Commit 3 - Dynamically changed location names and added fade effect 🔄✨**  
- Implemented dynamic location name updates with the photo location to personalize the user experience.  
- Added a smooth fade-in effect to images for a more visually appealing transition. 
  Use Glide CrossFade- To apply fade effect in images fetched from google.
  ```
  .transition(DrawableTransitionOptions.withCrossFade()) // Smooth transition
  ```
  Use animate() method - To apply fade effect in images fetched from local storage.
  ```
  private fun fadeInImage(imageView: ImageView) {
        imageView.alpha = 0f // Start with invisible
        imageView.animate()
            .alpha(1f) // Fade in to full opacity
            .setDuration(500) // Half a second
            .start()
    }
  ``` 
- Enhanced UI by making the app feel more interactive and polished. 

### **Commit $ - Implemented PhotoView to use zoom in/out feature. 🔍**  
- Integerate PhotoView library from github
```
implementation("io.github.chrisbanes:PhotoView:2.3.0")
```
- Added new activity to open the image for better visualization

