<template>
    <div id="messageBoard" class="container">
        <h2>Message Tree Board</h2>
        <div class="container">
            <table class="table">
                <thead>
                    Message
                </thead>
                <tbody>
                    <tr v-for="msg in messages" v-bind:key="msg.id">
                        <td>{{msg.content}}</td>
                        <td>{{msg.timestamp}}</td>
                    </tr>
                <div v-if="!showAddMsgForm">
                    <button v-on:click="showAddMsgForm = true">Add new post</button>
                </div>
                </tbody>
            </table>
        </div>


        <div v-if="showAddMsgForm">
            <form>
                <textarea v-model="message.content" type="text"></textarea>
            </form>
        </div>
    </div>
</template>

<script>
    import api from './backend-api';
    export default {
        name: "MessageTree",
        data() {
            return this.messages = [];
        },
        created(){
            this.allMessages();
        },
        methods : {
            allMessages()
            {
                api.getAll()
                    .then(response => {
                        this.console.log("Data loaded: ", response.data)
                        this.messages = response.data
                    })
                    .catch(err => {
                        this.console.log(err)
                        err = "Failed to load messages"
                    })
                    .finally(() => this.loading = false);
            },
            createMessage(msg)
            {
                api.createNew(msg)
                    .then(response => {
                        this.console.log("Data loaded: ", response.data)
                        this.newMessage = response.data
                    })
                    .catch(err => {
                        this.console.log(err)
                        err = "Failed to create messages"
                    })
                    .finally(() => this.loading = false);
            },

        }
    }

</script>

<style scoped>

</style>
