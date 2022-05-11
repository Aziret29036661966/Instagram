package com.example.instagram;

    public class NoteModel {
        private int userAvatar;
        private  String userName, description, date;

        public NoteModel(int userAvatar, String userName, String description, String date) {
            this.userAvatar = userAvatar;
            this.userName = userName;
            this.description = description;
            this.date = date;
        }
        public int getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(int userAvatar) {
            this.userAvatar = userAvatar;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTitle() {
            return 0;
        }
    }
