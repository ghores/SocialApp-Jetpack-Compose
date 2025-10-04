package com.example.socialapp.data

import com.example.socialapp.data.model.ActivityItem
import com.example.socialapp.data.model.Post
import com.example.socialapp.data.model.Story
import com.example.socialapp.data.model.enums.ActivityType
import kotlin.random.Random

class MockDataRepository {
    companion object {
        private val stories = mutableListOf<Story>()
        private val posts = mutableListOf<Post>()
        private var id: Int = 0
        private fun getId(): Int {
            id++
            return id
        }

        private fun getAvatar(): String {
            val gender = if (Random.nextBoolean()) "women" else "men"
            return "https://randomuser.me/api/portraits/${gender}/${Random.nextInt(1, 100)}.jpg"
        }

        fun getImage(): String {
            return "https://picsum.photos/id/${Random.nextInt(1, 100)}/600/300"
        }

        private fun getStoryImage(): String {
            return "https://picsum.photos/id/${Random.nextInt(1, 100)}/540/960"
        }

        fun getRandomStory(): Story {
            val result = Story(
                getId(),
                MockNameRepository.getRandomName(),
                getAvatar(),
                getStoryImage()
            )
            stories.add(result)
            return result
        }

        fun getRandomPost(): Post {
            val post = Post(
                getId(),
                MockNameRepository.getRandomName(),
                getAvatar(),
                getImage(),
                MockStringRepository().getRandomCaption()
            )
            posts.add(post)
            return post
        }

        fun getStoryById(id: Int): Story? {
            return stories.firstOrNull { it.id == id }
        }

        fun getRandomActivity(): ActivityItem {
            return ActivityItem(
                MockNameRepository.getRandomName(),
                getAvatar(),
                getRandomActivityType(),
                "${Random.nextInt(1, 23)}h",
                getImage()
            )
        }

        private fun getRandomActivityType(): ActivityType {
            val rnd = Random.nextInt(1, 100)
            return if (rnd % 5 == 0) {
                ActivityType.Comment
            } else if (rnd % 3 == 0) {
                ActivityType.Follow
            } else {
                ActivityType.Like
            }
        }
    }
}