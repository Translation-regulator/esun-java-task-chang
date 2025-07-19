<template>
  <div class="container">
    <h2>金融商品喜好紀錄系統</h2>

    <!-- 新增表單 -->
    <form @submit.prevent="addLike">
      <input v-model="form.productName" placeholder="商品名稱" required />
      <input v-model.number="form.price" type="number" placeholder="價格" required />
      <input v-model.number="form.feeRate" type="number" placeholder="手續費率" required />
      <input v-model="form.account" placeholder="預計扣款帳號" required />
      <input v-model.number="form.quantity" type="number" placeholder="購買數量" required />
      <button type="submit">新增</button>
    </form>

    <!-- 清單 -->
    <table>
      <thead>
        <tr>
          <th>商品名稱</th><th>價格</th><th>手續費率</th><th>帳號</th><th>數量</th><th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in likes" :key="item.sn">
          <td>
            <input v-if="editSn === item.sn" v-model="editForm.productName" />
            <span v-else>{{ item.productName }}</span>
          </td>
          <td>
            <input v-if="editSn === item.sn" v-model.number="editForm.price" type="number" />
            <span v-else>{{ item.price }}</span>
          </td>
          <td>
            <input v-if="editSn === item.sn" v-model.number="editForm.feeRate" type="number" />
            <span v-else>{{ item.feeRate }}</span>
          </td>
          <td>
            <input v-if="editSn === item.sn" v-model="editForm.account" />
            <span v-else>{{ item.account }}</span>
          </td>
          <td>
            <input v-if="editSn === item.sn" v-model.number="editForm.quantity" type="number" />
            <span v-else>{{ item.quantity }}</span>
          </td>
          <td>
            <button v-if="editSn === item.sn" @click="saveEdit(item.sn)">儲存</button>
            <button v-else @click="startEdit(item)">編輯</button>
            <button @click="remove(item.sn)">刪除</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getLikes, createLike, deleteLike, updateLike } from '@/api/likes'

const likes = ref([])
const form = ref({
  productName: '',
  price: 0,
  feeRate: 0,
  account: '',
  quantity: 1
})

const editSn = ref(null)
const editForm = ref({})

const fetchLikes = async () => {
  const res = await getLikes()
  likes.value = res.data
}

const addLike = async () => {
  await createLike(form.value)
  form.value = { productName: '', price: 0, feeRate: 0, account: '', quantity: 1 }
  fetchLikes()
}

const remove = async (sn) => {
  await deleteLike(sn)
  fetchLikes()
}

const startEdit = (item) => {
  editSn.value = item.sn
  editForm.value = { ...item }
}

const saveEdit = async (sn) => {
  await updateLike(sn, editForm.value)
  editSn.value = null
  fetchLikes()
}

onMounted(fetchLikes)
</script>

<style scoped>
.container {
  padding: 1rem;
}
input {
  margin: 0.2rem;
}
table {
  width: 100%;
  margin-top: 1rem;
  border-collapse: collapse;
}
th, td {
  border: 1px solid #aaa;
  padding: 0.5rem;
}
</style>
